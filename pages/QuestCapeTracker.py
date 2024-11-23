import json
import os
import tkinter as tk
from tkinter import ttk

from PIL import Image, ImageTk
from dotenv import load_dotenv

class QuestCapeTracker(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller

        # Define the quests data (years and their respective quests)
        self.quests = {
            "2001": ["Cook's Assistant", "Demon Slayer", "The Restless Ghost", "Sheep Shearer", "Shield of Arrav", "Ernest the Chicken", "Vampire Slayer", "Imp Catcher", "Stolen Hearts", "Diamond in the Rough", "What's Mine is Yours", "Witch's Potion", "The Knight's Sword", "Goblin Diplomacy", "Pirate's Treasure", "Dragon Slayer"],
            "2002": ["Quest 3", "Quest 4"]
        }

        # Main canvas for the entire page
        self.main_canvas = tk.Canvas(self, width=640, height=720, highlightthickness=0, bg="#0B1F29")
        self.main_canvas.place(x=0, y=0, relwidth=1, relheight=1)
        self.main_canvas.create_text(320, 50, text="Quest Cape Tracker", font=("Arial", 24, "bold"), fill="white")

        # Skill canvas on the left side
        self.skill_canvas = tk.Canvas(self, width=250, height=450, highlightthickness=1, bg="#1E1E1E")
        self.skill_canvas.place(x=20, y=125)

        # Quest list frame on the right side
        self.quest_frame = tk.Frame(self, width=250, height=450, bg="#1E1E1E")
        self.quest_frame.place(x=370, y=125)

        # File to store quest states
        self.quests_file = "Mem/quests.json"
        self.quest_states = self.load_quests()

        # Create the quest list
        self.create_quest_list()

        # Initialize data
        self.players_dir = os.path.join(os.path.dirname(os.path.abspath(__file__)), "../Players")
        self.selected_player = tk.StringVar(self)
        self.skill_icons = {}

        # Dropdown for players
        self.load_players()
        dropdown = tk.OptionMenu(self, self.selected_player, *self.players, command=self.update_player_data)
        dropdown.config(width=20)
        self.main_canvas.create_window(320, 100, window=dropdown)

        # Load skill icons
        images_dir = os.path.join(os.path.dirname(os.path.abspath(__file__)), "../Images")
        self.load_skill_icons(images_dir)

        # Initialize skill grid
        self.create_grid()

        # Back button
        back_button = tk.Button(self, text="Back to Main Menu", command=lambda: controller.show_frame("MainMenu"))
        self.main_canvas.create_window(320, 600, window=back_button)

        # Save quests on close
        self.controller.protocol("WM_DELETE_WINDOW", self.save_quests)

    def load_players(self):
        self.players = [f.replace(".env", "") for f in os.listdir(self.players_dir) if f.endswith(".env")]

        if self.players:
            self.selected_player.set(self.players[0])
            self.update_player_data(self.players[0])

    def update_player_data(self, player_name):
        env_path = os.path.join(self.players_dir, f"{player_name}.env")

        if os.path.exists(env_path):
            load_dotenv(env_path, override=True)
            self.skill_canvas.delete("grid")
            self.create_grid()

    def create_grid(self):
        self.skill_canvas.delete("grid")
        cell_width = 75
        cell_height = 35
        gap = 5
        start_x = 10  # Padding from the left side of the skill canvas
        start_y = 20  # Padding from the top of the skill canvas

        # Skill levels and data
        att = 79
        stre = 85
        Def = 76
        ran = 78
        pra = 80
        mag = 81
        run = 85
        con = 81
        dun = 77
        arc = 86
        cons = 80
        agi = 83
        her = 80
        thi = 85
        cra = 91
        fle = 75
        sla = 90
        hun = 90
        div = 90
        nec = 95
        mini = 90
        smi = 85
        fis = 90
        coo = 91
        fir = 82
        woo = 90
        far = 86
        summ = 75
        inv = 85

        data = [
            [("ATTACK", os.getenv("ATTACK_LEVEL") + f" / {att}"), ("CONSTITUTION", os.getenv("CONSTITUTION_LEVEL") + f" / {cons}"), ("MINING", os.getenv("MINING_LEVEL") + f" / {mini}")],
            [("STRENGTH", os.getenv("STRENGTH_LEVEL") + f" / {stre}"), ("AGILITY", os.getenv("AGILITY_LEVEL") + f" / {agi}"), ("SMITHING", os.getenv("SMITHING_LEVEL") + f" / {smi}")],
            [("DEFENCE", os.getenv("DEFENCE_LEVEL") + f" / {Def}"), ("HERBLORE", os.getenv("HERBLORE_LEVEL") + f" / {her}"), ("FISHING", os.getenv("FISHING_LEVEL") + f" / {fis}")],
            [("RANGED", os.getenv("RANGED_LEVEL") + f" / {ran}"), ("THIEVING", os.getenv("THIEVING_LEVEL") + f" / {thi}"), ("COOKING", os.getenv("COOKING_LEVEL") + f" / {coo}")],
            [("PRAYER", os.getenv("PRAYER_LEVEL") + f" / {pra}"), ("CRAFTING", os.getenv("CRAFTING_LEVEL") + f" / {cra}"), ("FIREMAKING", os.getenv("FIREMAKING_LEVEL") + f" / {fir}")],
            [("MAGIC", os.getenv("MAGIC_LEVEL") + f" / {mag}"), ("FLETCHING", os.getenv("FLETCHING_LEVEL") + f" / {fle}"), ("WOODCUTTING", os.getenv("WOODCUTTING_LEVEL") + f" / {woo}")],
            [("RUNECRAFTING", os.getenv("RUNECRAFTING_LEVEL") + f" / {run}"), ("SLAYER", os.getenv("SLAYER_LEVEL") + f" / {sla}"), ("FARMING", os.getenv("FARMING_LEVEL") + f" / {far}")],
            [("CONSTRUCTION", os.getenv("CONSTRUCTION_LEVEL") + f" / {con}"), ("HUNTER", os.getenv("HUNTER_LEVEL") + f" / {hun}"), ("SUMMONING", os.getenv("SUMMONING_LEVEL") + f" / {summ}")],
            [("DUNGEONEERING", os.getenv("DUNGEONEERING_LEVEL") + f" / {dun}"), ("DIVINATION", os.getenv("DIVINATION_LEVEL") + f" / {div}"), ("INVENTION", os.getenv("INVENTION_LEVEL") + f" / {inv}")],
            [("ARCHAEOLOGY", os.getenv("ARCHAEOLOGY_LEVEL") + f" / {arc}"), ("NECROMANCY", os.getenv("NECROMANCY_LEVEL") + f" / {nec}")]
        ]

        for row in range(len(data)):
            for col in range(len(data[row])):
                x = start_x + col * (cell_width + gap)
                y = start_y + row * (cell_height + gap)

                skill_name, skill_level = data[row][col]

                try:
                    current_level, target_level = map(int, skill_level.split(" / "))
                    border_color = "yellow" if current_level >= target_level else "black"
                except ValueError:
                    # Handle invalid skill level formatting
                    border_color = "red"

                # Draw the skill grid
                self.skill_canvas.create_rectangle(
                    x, y, x + cell_width, y + cell_height,
                    outline=border_color, width=2, fill="#0B1F29", tags="grid"
                )

                # Draw skill icon and level text
                icon = self.skill_icons.get(skill_name.lower())
                icon_x = x + 20
                icon_y = y + cell_height / 2
                text_x = x + cell_width / 2
                text_y = y + cell_height / 2

                if icon:
                    self.skill_canvas.create_image(icon_x, icon_y, image=icon, anchor="center", tags="grid")

                self.skill_canvas.create_text(
                    text_x, text_y,
                    text=f"       {skill_level}",
                    font=("Arial", 8), fill="white", tags="grid"
                )

        self.skill_canvas.tag_raise("grid")

    def load_skill_icons(self, images_dir):
        skills = [
            "attack", "constitution", "mining", "strength", "agility", "smithing",
            "defence", "herblore", "fishing", "ranged", "thieving", "cooking",
            "prayer", "crafting", "firemaking", "magic", "fletching", "woodcutting",
            "runecrafting", "slayer", "farming", "construction", "hunter",
            "summoning", "dungeoneering", "divination", "invention", "archaeology",
            "necromancy"
        ]
        self.skill_icons = {}

        for skill in skills:
            icon_path = os.path.join(images_dir, f"{skill}.png")

            if os.path.exists(icon_path):
                img = Image.open(icon_path).resize((15, 15), Image.Resampling.LANCZOS)
                self.skill_icons[skill] = ImageTk.PhotoImage(img)

    def load_quests(self):
        """Load quest states from the JSON file."""
        if os.path.exists(self.quests_file):
            with open(self.quests_file, "r") as file:
                return json.load(file)
        else:
            # Default quest states with all quests incomplete
            return {year: {quest: False for quest in quests} for year, quests in self.quests.items()}

    def save_quests(self):
        """Save quest states to the JSON file."""
        with open(self.quests_file, "w") as file:
            json.dump(self.quest_states, file, indent=4)
        self.controller.destroy()  # Close the app

    def create_quest_list(self):
        """Create a togglable quest list."""
        # Clear previous widgets
        for widget in self.quest_frame.winfo_children():
            widget.destroy()

        # Add quests for each year
        row = 0
        for year, quests in self.quests.items():
            year_label = tk.Label(self.quest_frame, text=f"Year {year}", font=("Arial", 12, "bold"), bg="#1E1E1E", fg="white")
            year_label.grid(row=row, column=0, sticky="w", padx=10, pady=5)
            row += 1

            for quest_name in quests:
                completed = self.quest_states.get(year, {}).get(quest_name, False)
                var = tk.BooleanVar(value=completed)

                def toggle_quest(year=year, quest=quest_name, var=var):
                    self.quest_states[year][quest] = var.get()

                checkbox = tk.Checkbutton(
                    self.quest_frame,
                    text=quest_name,
                    variable=var,
                    onvalue=True,
                    offvalue=False,
                    command=toggle_quest,
                    bg="#1E1E1E",
                    fg="white",
                    selectcolor="#1E1E1E",
                    anchor="w"
                )
                checkbox.grid(row=row, column=0, sticky="w", padx=20, pady=2)
                row += 1