import os
import tkinter as tk
import requests
from PIL import Image, ImageTk
from tkinter import messagebox
from Pages.AreaTasksTracker import AreaTasksTracker
from Pages.CompCapeTracker import CompCapeTracker
from Pages.MasterMaxCapeTracker import MasterMaxCapeTracker
from Pages.MasterQuestCapeTracker import MasterQuestCapeTracker
from Pages.MaxCapeTracker import MaxCapeTracker
from Pages.QuestCapeTracker import QuestCapeTracker

class RS3Trackers(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("RS3 Trackers")
        self.geometry("640x360")
        self.resizable(False, False)
        self.base_dir = os.path.dirname(os.path.abspath(__file__))

        try:
            icon_path = os.path.join(self.base_dir, "Images", "rs3.ico")
            self.iconbitmap(icon_path)
        except Exception as e:
            messagebox.showerror("Error", f"Error setting icon: {e}")

        self.main_frame = tk.Frame(self)
        self.main_frame.pack(fill="both", expand=True)
        self.frames = {}
        self.rsn_entry = None
        self.create_main_menu()
        self.CreateQuestCapePage()
        self.CreateAreaTasksPage()
        self.CreateMasterQuestCapePage()
        self.CreateMaxCapePage()
        self.CreateCompCapePage()
        self.CreateMasterMaxCapePage()
        self.show_frame("MainMenu")

    def create_main_menu(self):
        main_menu = tk.Frame(self.main_frame)
        self.frames["MainMenu"] = main_menu
        main_menu.pack(fill="both", expand=True)

        try:
            background_path = os.path.join(self.base_dir, "Images", "rs3.png")
            questcape_path = os.path.join(self.base_dir, "Images", "questcape.png")
            areatasks_path = os.path.join(self.base_dir, "Images", "areatasks.png")
            masterquestcape_path = os.path.join(self.base_dir, "Images", "masterquestcape.png")
            maxcape_path = os.path.join(self.base_dir, "Images", "maxcape.png")
            compcape_path = os.path.join(self.base_dir, "Images", "completionistcape.png")
            mastermaxcape_path = os.path.join(self.base_dir, "Images", "mastermaxcape.png")

            background_open = Image.open(background_path)
            background_resize = background_open.resize((640, 360), Image.Resampling.LANCZOS)
            bg_photo = ImageTk.PhotoImage(background_resize)
            bg_label = tk.Label(main_menu, image=bg_photo)
            bg_label.image = bg_photo
            bg_label.place(x=0, y=0, relwidth=1, relheight=1)

            self.questcape = ImageTk.PhotoImage(Image.open(questcape_path).resize((40, 85), Image.Resampling.LANCZOS))
            self.areatasks = ImageTk.PhotoImage(Image.open(areatasks_path).resize((28, 28), Image.Resampling.LANCZOS))
            self.masterquestcape = ImageTk.PhotoImage(Image.open(masterquestcape_path).resize((40, 85), Image.Resampling.LANCZOS))
            self.maxcape = ImageTk.PhotoImage(Image.open(maxcape_path).resize((40, 85), Image.Resampling.LANCZOS))
            self.compcape = ImageTk.PhotoImage(Image.open(compcape_path).resize((40, 85), Image.Resampling.LANCZOS))
            self.mastermaxcape = ImageTk.PhotoImage(Image.open(mastermaxcape_path).resize((40, 85), Image.Resampling.LANCZOS))
        except Exception as e:
            messagebox.showerror("Error", f"Error loading image: {e}")


        canvas = tk.Canvas(main_menu, width=640, height=360, highlightthickness=0)
        canvas.place(x=0, y=0, relwidth=1, relheight=1)
        canvas.create_image(0, 0, anchor="nw", image=bg_photo)

        canvas.create_text(320, 50, text="RS3 Trackers", font=("Arial", 36, "bold"), fill="white")
        canvas.create_text(250, 100, text="Runescape Username:", font=("Arial", 12, "bold"), fill="white")

        self.rsn_entry = tk.Entry(main_menu)
        canvas.create_window(400, 100, window=self.rsn_entry)
        v_button = tk.Button(main_menu, text="Update Hiscores", command=self.validate_rsn)
        canvas.create_window(320, 130, window=v_button)

        qc_btn_id = canvas.create_image(170, 250, image=self.questcape, anchor="center")
        canvas.tag_bind(qc_btn_id, "<Button-1>", lambda event: self.show_frame("QuestCapeTracker"))
        at_btn_id = canvas.create_image(230, 250, image=self.areatasks, anchor="center")
        canvas.tag_bind(at_btn_id, "<Button-1>", lambda event: self.show_frame("AreaTasksTracker"))
        mqc_btn_id = canvas.create_image(290, 250, image=self.masterquestcape, anchor="center")
        canvas.tag_bind(mqc_btn_id, "<Button-1>", lambda event: self.show_frame("MasterQuestCapeTracker"))
        mc_btn_id = canvas.create_image(350, 250, image=self.maxcape, anchor="center")
        canvas.tag_bind(mc_btn_id, "<Button-1>", lambda event: self.show_frame("MaxCapeTracker"))
        cc_btn_id = canvas.create_image(410, 250, image=self.compcape, anchor="center")
        canvas.tag_bind(cc_btn_id, "<Button-1>", lambda event: self.show_frame("CompCapeTracker"))
        mmc_btn_id = canvas.create_image(470, 250, image=self.mastermaxcape, anchor="center")
        canvas.tag_bind(mmc_btn_id, "<Button-1>", lambda event: self.show_frame("MasterMaxCapeTracker"))

    def CreateAreaTasksPage(self):
        AreaTasksPage = AreaTasksTracker(self.main_frame, self)
        self.frames["AreaTasksTracker"] = AreaTasksPage
        AreaTasksPage.place(x=0, y=0, relwidth=1, relheight=1)

    def CreateCompCapePage(self):
        CompCapePage = CompCapeTracker(self.main_frame, self)
        self.frames["CompCapeTracker"] = CompCapePage
        CompCapePage.place(x=0, y=0, relwidth=1, relheight=1)

    def CreateMasterMaxCapePage(self):
        MasterMaxCapePage = MasterMaxCapeTracker(self.main_frame, self)
        self.frames["MasterMaxCapeTracker"] = MasterMaxCapePage
        MasterMaxCapePage.place(x=0, y=0, relwidth=1, relheight=1)

    def CreateMasterQuestCapePage(self):
        MasterQuestCapePage = MasterQuestCapeTracker(self.main_frame, self)
        self.frames["MasterQuestCapeTracker"] = MasterQuestCapePage
        MasterQuestCapePage.place(x=0, y=0, relwidth=1, relheight=1)

    def CreateMaxCapePage(self):
        MaxCapePage = MaxCapeTracker(self.main_frame, self)
        self.frames["MaxCapeTracker"] = MaxCapePage
        MaxCapePage.place(x=0, y=0, relwidth=1, relheight=1)

    def CreateQuestCapePage(self):
        QuestCapePage = QuestCapeTracker(self.main_frame, self)
        self.frames["QuestCapeTracker"] = QuestCapePage
        QuestCapePage.place(x=0, y=0, relwidth=1, relheight=1)

    def show_frame(self, page_name):
        frame = self.frames[page_name]

        if page_name == "MainMenu":
            self.geometry("640x360")
        elif page_name == "QuestCapeTracker":
            self.geometry("640x720")
        elif page_name == "AreaTasksTracker":
            self.geometry("640x720")
        else:
            self.geometry("1280x720")
        frame.tkraise()

    def validate_rsn(self):
        rsn = self.rsn_entry.get().strip()
        if not rsn:
            messagebox.showwarning("Warning", "Please enter a RuneScape username.")
            return

        url = f"https://secure.runescape.com/m=hiscore/index_lite.ws?player={rsn}"
        try:
            response = requests.get(url)
            response.raise_for_status()

            players_dir = os.path.join(self.base_dir, "Players")
            os.makedirs(players_dir, exist_ok=True)
            env_file_path = os.path.join(players_dir, f"{rsn}.env")

            skills = [
                "Overall", "Attack", "Defence", "Strength", "Constitution", "Ranged", "Prayer",
                "Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking",
                "Crafting", "Smithing", "Mining", "Herblore", "Agility", "Thieving", "Slayer",
                "Farming", "Runecrafting", "Hunter", "Construction", "Summoning", "Dungeoneering",
                "Divination", "Invention", "Archaeology", "Necromancy"
            ]

            hiscores_data = response.text
            data_rows = hiscores_data.splitlines()
            env_lines = []
            for i, row in enumerate(data_rows):
                columns = row.split(",")
                if len(columns) == 3:
                    skill_name = skills[i] if i < len(skills) else f"{i + 1}"
                    rank, level, xp = columns
                    env_lines.append(f"{skill_name.upper()}_RANK={rank}")
                    env_lines.append(f"{skill_name.upper()}_LEVEL={level}")
                    env_lines.append(f"{skill_name.upper()}_XP={xp}")

            with open(env_file_path, "w") as env_file:
                env_file.write("\n".join(env_lines))

            messagebox.showinfo("Success", f"Hiscores data saved for {rsn}.")
        except requests.RequestException as e:
            messagebox.showerror("Error", f"Failed to fetch hiscores for {rsn}.\nError: {e}")


if __name__ == "__main__":
    app = RS3Trackers()
    app.mainloop()