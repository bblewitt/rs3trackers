import tkinter as tk

class MasterQuestCapeTracker(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller

        # Create a canvas for placing items
        canvas = tk.Canvas(self, width=1280, height=720, highlightthickness=0, bg="white")
        canvas.place(x=0, y=0, relwidth=1, relheight=1)

        # Title
        canvas.create_text(640, 50, text="Master Quest Cape Tracker", font=("Arial", 24, "bold"), fill="black")

        # Back button to return to the main menu
        back_button = tk.Button(self, text="Back to Main Menu", command=lambda: controller.show_frame("MainMenu"))
        canvas.create_window(640, 150, window=back_button)