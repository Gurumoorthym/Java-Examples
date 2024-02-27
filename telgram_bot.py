import subprocess
import logging
import os
import time
from telegram import Update, ReplyKeyboardMarkup
from telegram.ext import Updater, CommandHandler, CallbackContext, MessageHandler, Filters, ConversationHandler

from telegram import ChatAction

# Define your bot token here
TOKEN = ''

# Define the list of authorized users
AUTHORIZED_USERS = ["doluserver"]

# Conversation states
PIC, SWAP_PIC, VIDEO, SWAP_VIDEO, FALLBACK = range(5)

def start(update, context):
    context.bot.send_message(chat_id=update.effective_chat.id, text=f"Welcome to your server bot! :{update.message.from_user.username}")
    help(update, context)

def button_click(update, context):
    query = update.callback_query
    query.answer()
    if query.data == 'change_pic':
        change_pic(update, context)
    elif query.data == 'change_video':
        change_video(update, context)
    elif query.data == 'help':
        help(update, context)

def help(update, context):
    help_text = """
    Available commands:
    /change_pic - Swap an image with another image
    /change_video - Swap an image with a video
    """
    context.bot.send_message(chat_id=update.effective_chat.id, text=help_text)

def change_pic(update, context):
    context.bot.send_message(chat_id=update.effective_chat.id, text="Please upload the image to be swapped (less than 2MB).")
    return PIC

def pic_received(update, context):
    file = context.bot.get_file(update.message.photo[-1].file_id)
    file.download('/home/dolu/git/roop/Changed/pic_to_swap.jpg')
    context.user_data['mode'] = 'PIC'
    context.bot.send_message(chat_id=update.effective_chat.id, text="Please upload the file to swap with (less than 2MB).")
    return SWAP_PIC

def swap_pic(update, context):
    file = context.bot.get_file(update.message.photo[-1].file_id)
    file.download('/home/dolu/git/roop/Changed/pic_to_swap_with.jpg')
    context.bot.send_message(chat_id=update.effective_chat.id, text="Image received! Now processing...")
    execute_command(update, context)
    return ConversationHandler.END

def change_video(update, context):
    context.bot.send_message(chat_id=update.effective_chat.id, text="Please upload the image to be swapped (less than 2MB).")
    return VIDEO

def video_received(update, context):
    file = context.bot.get_file(update.message.photo[-1].file_id)
    file.download('/home/dolu/git/roop/Changed/video_to_swap.jpg')
    context.user_data['mode'] = 'VIDEO'
    context.bot.send_message(chat_id=update.effective_chat.id, text="Please upload the video to swap with (less than 20MB).")
    return SWAP_VIDEO

def swap_video(update, context):
    file = context.bot.get_file(update.message.video.file_id)
    file.download('/home/dolu/git/roop/Changed/video_to_swap_with.mp4')
    context.bot.send_message(chat_id=update.effective_chat.id, text="Video received! Now processing...")
    execute_command(update, context)
    return ConversationHandler.END

def execute_command(update, context):
    # Configure logging
    logging.basicConfig(filename='app.log', level=logging.DEBUG, format='%(asctime)s - %(levelname)s - %(message)s')
    source_path = ""
    target_path = ""
    output_file = ""
    if context.user_data['mode'] == 'PIC':
        source_path = "/home/dolu/git/roop/Changed/pic_to_swap.jpg"
        target_path = "/home/dolu/git/roop/Changed/pic_to_swap_with.jpg"
        output_file = "/home/dolu/git/roop/Changed/swapped_pic.jpg"
    elif context.user_data['mode'] == 'VIDEO':
        source_path = "/home/dolu/git/roop/Changed/video_to_swap.jpg"
        target_path = "/home/dolu/git/roop/Changed/video_to_swap_with.mp4"
        output_file = "/home/dolu/git/roop/Changed/changed.mp4"
    try:
        command = f"python3 ~/git/roop/run.py -s {source_path} -t {target_path} -o {output_file} --output-video-encoder 'h264_nvenc' --keep-fps --execution-threads 64 --max-memory 30 --execution-provider cuda "
        process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, universal_newlines=True)
        # Output command logs
        for line in process.stdout:
            logging.info(line.strip())
            #context.bot.send_message(chat_id=update.effective_chat.id, text=line.strip())
        process.wait()  # Wait for the command to finish
        if os.path.exists(output_file):
            # Check file size before sending
            file_size_mb = os.path.getsize(output_file) / (1024 * 1024)  # Convert bytes to megabytes
            if file_size_mb > 19:
                logging.error("Output file size exceeds 19MB limit. File not deleted.")
                context.bot.send_message(chat_id=update.effective_chat.id, text="Error: File Size is larger than 19MB, Check Server for the file.")
            else:
                with open(output_file, "rb") as file:
                    context.bot.send_document(chat_id=update.effective_chat.id, document=file)
        else:
            logging.error("Output file not found")
            context.bot.send_message(chat_id=update.effective_chat.id, text="Error: Output file not found.")
    except Exception as e:
        logging.error("Exception")
        context.bot.send_message(chat_id=update.effective_chat.id, text=f"Error: {str(e)}")
    finally:
        # Remove the file after sending
        os.remove(source_path)
        os.remove(target_path)
        if os.path.exists(output_file) and not (os.path.getsize(output_file) / (1024 * 1024)) > 19:
            os.remove(output_file)
            help(update,context)
    pass

def fallback(update, context):
    context.bot.send_message(chat_id=update.effective_chat.id, text="Sorry, I didn't understand that command.")
    return ConversationHandler.END


def main():
    updater = Updater(token=TOKEN, use_context=True)
    dispatcher = updater.dispatcher

    conv_handler = ConversationHandler(
        entry_points=[CommandHandler('start', start), CommandHandler('help', help), CommandHandler('change_pic', change_pic), CommandHandler('change_video', change_video)],
        states={
            PIC: [MessageHandler(Filters.photo & ~Filters.command, pic_received)],
            SWAP_PIC: [MessageHandler(Filters.photo & ~Filters.command, swap_pic)],
            VIDEO: [MessageHandler(Filters.photo & ~Filters.command, video_received)],
            SWAP_VIDEO: [MessageHandler(Filters.video & ~Filters.command, swap_video)],
            FALLBACK: [MessageHandler(Filters.text & ~Filters.command, fallback)]
        },
        fallbacks=[CommandHandler('start', start), CommandHandler('help', help), CommandHandler('change_pic', change_pic), CommandHandler('change_video', change_video), fallback]
    )

    dispatcher.add_handler(conv_handler)
    updater.start_polling()

if __name__ == '__main__':
    main()

