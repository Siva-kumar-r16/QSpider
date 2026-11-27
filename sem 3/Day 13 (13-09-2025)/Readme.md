# QSpider Python Notes — 13-09-2025

## Date: 13-09-2025

## Programs Practiced

### `project.py`

```python
import tkinter as tk
from tkinter import messagebox
import random
import pickle
import smtplib
import ssl
from email.message import EmailMessage

class DominoApp:
    def __init__(self):
        self.users_file = 'users.bin'
        self.users = self.load_users()
        self.current_user = None
        self.loginsta = False
        self.cart = {}
        self.menu = {
            'veg': {'Paneer Pizza': 250, 'Veg Burger': 150},
            'nonveg': {'Chicken Pizza': 300, 'Chicken Burger': 200},
            'snacks': {'Fries': 100, 'Nuggets': 120},
            'desserts': {'Ice Cream': 80, 'Brownie': 90},
            'drinks': {'Coke': 50, 'Juice': 60}
        }
        self.all_prices = self.get_all_prices()

    def get_all_prices(self):
        prices = {}
        for category in self.menu.values():
            prices.update(category)
        return prices

    def load_users(self):
        try:
            with open(self.users_file, 'rb') as f:
                return pickle.load(f)
        except (FileNotFoundError, EOFError):
            return []

    def save_users(self):
        with open(self.users_file, 'wb') as f:
            pickle.dump(self.users, f)

    def register(self, username, email, phno):
        if any(user['username'] == username or user['email'] == email or user['phno'] == phno for user in self.users):
            return False, "A user with that username, email, or phone number already exists."
        
        new_user = {'username': username, 'email': email, 'phno': phno}
        self.users.append(new_user)
        self.save_users()
        return True, "Registration successful! Please login."

    def send_otp_email(self, receiver_email, otp):
        # This is a placeholder function for the GUI.
        # In a real-world scenario, you would put your email sending code here.
        messagebox.showinfo("OTP Sent", f"OTP {otp} sent to {receiver_email}. (Email sending is simulated)")

    def send_otp_whatsapp(self, phone_number, otp):
        # This is a placeholder function for the GUI.
        # In a real-world scenario, you would put your WhatsApp sending code here.
        messagebox.showinfo("OTP Sent", f"OTP {otp} sent to {phone_number}. (WhatsApp sending is simulated)")
    
    def valid_otp(self, user_details):
        otp = random.randint(1000, 9999)
        self.send_otp_email(user_details['email'], otp)
        self.send_otp_whatsapp(user_details['phno'], otp)
        return otp

    def login(self, email_or_phno):
        found_user = next((user for user in self.users if user['email'] == email_or_phno or user['phno'] == email_or_phno), None)
        if found_user:
            self.current_user = found_user
            return True, None
        else:
            return False, "Invalid email or phone number."

    def get_menu_items(self, category):
        return self.menu.get(category, {})
    
    def add_to_cart(self, item_name, quantity):
        if item_name in self.cart:
            self.cart[item_name] += quantity
        else:
            self.cart[item_name] = quantity
        return f"{quantity} x {item_name} added to your cart."

    def get_cart_summary(self):
        if not self.cart:
            return "Your cart is empty.", 0, ""
        
        summary = "--- Your Cart ---\n"
        total_price = 0
        for item, quantity in self.cart.items():
            price = self.all_prices.get(item, 0)
            item_total = price * quantity
            total_price += item_total
            summary += f"{item} ({quantity}) - ₹{item_total}\n"
        summary += f"\nTotal Price: ₹{total_price}"
        return "Your cart is not empty.", total_price, summary

    def place_order(self):
        if not self.cart:
            return "Your cart is empty. Please add items before placing an order."
        self.cart = {}
        return "Order placed successfully!"

    def logout(self):
        self.loginsta = False
        self.current_user = None
        self.cart = {}
        return "Logged out successfully."

class App(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Domino's App")
        self.geometry("400x400")
        self.domino_app = DominoApp()
        
        self.frames = {}
        self.create_frames()
        self.show_frame("WelcomeFrame")

    def create_frames(self):
        container = tk.Frame(self)
        container.pack(fill="both", expand=True)
        
        for F in (WelcomeFrame, LoginFrame, OtpFrame, MainMenuFrame, OrderMenuFrame, CartFrame, RegisterFrame):
            frame = F(container, self)
            self.frames[F.__name__] = frame
            frame.grid(row=0, column=0, sticky="nsew")

    def show_frame(self, page_name, data=None):
        frame = self.frames[page_name]
        frame.tkraise()
        if page_name == "MainMenuFrame":
            frame.update_welcome_message()
        if page_name == "LoginFrame":
            frame.clear_fields()
        if page_name == "CartFrame":
            frame.update_cart()
        if page_name == "OrderMenuFrame":
            frame.update_menu()
        if page_name == "OtpFrame" and data:
            frame.set_otp_user(data)

class WelcomeFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.columnconfigure(0, weight=1)
        
        label = tk.Label(self, text="Welcome to Domino's!", font=("Arial", 18))
        label.grid(row=0, column=0, pady=(40, 10))
        
        register_btn = tk.Button(self, text="Register", command=lambda: controller.show_frame("RegisterFrame"))
        register_btn.grid(row=1, column=0, pady=5, ipadx=20)
        
        login_btn = tk.Button(self, text="Login", command=lambda: controller.show_frame("LoginFrame"))
        login_btn.grid(row=2, column=0, pady=5, ipadx=20)

class LoginFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.columnconfigure(0, weight=1)
        self.email_or_phno = tk.StringVar()
        
        label = tk.Label(self, text="Login", font=("Arial", 14))
        label.grid(row=0, column=0, pady=(40, 10))
        
        tk.Label(self, text="Email or Phone Number:").grid(row=1, column=0, pady=5)
        self.entry = tk.Entry(self, textvariable=self.email_or_phno)
        self.entry.grid(row=2, column=0, pady=5)
        
        self.message_label = tk.Label(self, text="", fg="red")
        self.message_label.grid(row=3, column=0, pady=5)
        
        tk.Button(self, text="Login", command=self.login).grid(row=4, column=0, pady=5)
        tk.Button(self, text="Back", command=lambda: self.controller.show_frame("WelcomeFrame")).grid(row=5, column=0, pady=5)

    def login(self):
        email_or_phno = self.email_or_phno.get()
        success, message = self.controller.domino_app.login(email_or_phno)
        if success:
            otp = self.controller.domino_app.valid_otp(self.controller.domino_app.current_user)
            self.controller.show_frame("OtpFrame", data={'otp': otp, 'user_details': self.controller.domino_app.current_user})
        else:
            self.message_label.config(text=message)

    def clear_fields(self):
        self.email_or_phno.set("")
        self.message_label.config(text="")

class RegisterFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.columnconfigure(0, weight=1)
        
        self.username = tk.StringVar()
        self.email = tk.StringVar()
        self.phno = tk.StringVar()
        
        tk.Label(self, text="Register a New Account", font=("Arial", 14)).grid(row=0, column=0, pady=(40, 10))
        
        tk.Label(self, text="Username:").grid(row=1, column=0, pady=2)
        tk.Entry(self, textvariable=self.username).grid(row=2, column=0, pady=2)
        
        tk.Label(self, text="Email:").grid(row=3, column=0, pady=2)
        tk.Entry(self, textvariable=self.email).grid(row=4, column=0, pady=2)
        
        tk.Label(self, text="Phone Number:").grid(row=5, column=0, pady=2)
        tk.Entry(self, textvariable=self.phno).grid(row=6, column=0, pady=2)
        
        self.message_label = tk.Label(self, text="", fg="red")
        self.message_label.grid(row=7, column=0, pady=5)
        
        tk.Button(self, text="Submit", command=self.submit_registration).grid(row=8, column=0, pady=5)
        tk.Button(self, text="Back to Login", command=lambda: controller.show_frame("LoginFrame")).grid(row=9, column=0, pady=5)

    def submit_registration(self):
        success, message = self.controller.domino_app.register(self.username.get(), self.email.get(), self.phno.get())
        if success:
            messagebox.showinfo("Success", message)
            self.controller.show_frame("LoginFrame")
        else:
            self.message_label.config(text=message)

class OtpFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.columnconfigure(0, weight=1)
        self.otp_code = None
        self.user_details = None
        
        tk.Label(self, text="OTP Verification", font=("Arial", 14)).grid(row=0, column=0, pady=(40, 10))
        
        tk.Label(self, text="Enter OTP:").grid(row=1, column=0, pady=5)
        self.otp_entry = tk.Entry(self)
        self.otp_entry.grid(row=2, column=0, pady=5)
        
        self.message_label = tk.Label(self, text="", fg="red")
        self.message_label.grid(row=3, column=0, pady=5)
        
        tk.Button(self, text="Verify OTP", command=self.verify_otp).grid(row=4, column=0, pady=5)

    def set_otp_user(self, data):
        self.otp_code = data['otp']
        self.user_details = data['user_details']
    
    def verify_otp(self):
        try:
            user_otp = int(self.otp_entry.get())
            if user_otp == self.otp_code:
                self.controller.domino_app.loginsta = True
                self.controller.show_frame("MainMenuFrame")
            else:
                self.message_label.config(text="Invalid OTP. Please try again.")
        except ValueError:
            self.message_label.config(text="Invalid input. Please enter a number.")
            
class MainMenuFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.columnconfigure(0, weight=1)
        
        self.welcome_label = tk.Label(self, text="", font=("Arial", 14))
        self.welcome_label.grid(row=0, column=0, pady=(40, 10))
        
        tk.Button(self, text="Order Items", command=lambda: controller.show_frame("OrderMenuFrame")).grid(row=1, column=0, pady=5)
        tk.Button(self, text="View Cart", command=lambda: controller.show_frame("CartFrame")).grid(row=2, column=0, pady=5)
        tk.Button(self, text="Place Order", command=self.place_order).grid(row=3, column=0, pady=5)
        tk.Button(self, text="Logout", command=self.logout).grid(row=4, column=0, pady=5)

    def update_welcome_message(self):
        username = self.controller.domino_app.current_user['username']
        self.welcome_label.config(text=f"Hi {username}, Welcome to Domino's!")

    def place_order(self):
        message = self.controller.domino_app.place_order()
        messagebox.showinfo("Order Status", message)
        self.controller.show_frame("MainMenuFrame")

    def logout(self):
        message = self.controller.domino_app.logout()
        messagebox.showinfo("Logout", message)
        self.controller.show_frame("WelcomeFrame")

class OrderMenuFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.category_frame = tk.Frame(self)
        self.category_frame.pack(pady=10)
        self.item_frame = tk.Frame(self)
        self.item_frame.pack(pady=10)
        self.selected_category = None
        self.selected_item = None
        self.quantity_var = tk.IntVar(value=1)

        tk.Button(self, text="Back to Main Menu", command=lambda: controller.show_frame("MainMenuFrame")).pack(pady=5)
        self.update_menu()

    def clear_frame(self, frame):
        for widget in frame.winfo_children():
            widget.destroy()

    def update_menu(self):
        self.clear_frame(self.category_frame)
        self.clear_frame(self.item_frame)
        
        tk.Label(self.category_frame, text="Select a Category", font=("Arial", 14)).pack()
        for i, category in enumerate(self.controller.domino_app.menu.keys()):
            tk.Button(self.category_frame, text=category.capitalize(), command=lambda cat=category: self.show_items(cat)).pack(pady=2)

    def show_items(self, category):
        self.clear_frame(self.item_frame)
        self.selected_category = category
        
        tk.Label(self.item_frame, text=f"--- {category.capitalize()} Menu ---", font=("Arial", 12)).pack()
        items = self.controller.domino_app.get_menu_items(category)
        
        for item_name, price in items.items():
            frame = tk.Frame(self.item_frame)
            frame.pack(pady=2)
            tk.Label(frame, text=f"{item_name} - ₹{price}").pack(side="left", padx=5)
            tk.Button(frame, text="Add", command=lambda name=item_name: self.show_quantity_prompt(name)).pack(side="right", padx=5)

    def show_quantity_prompt(self, item_name):
        self.selected_item = item_name
        self.clear_frame(self.item_frame)
        
        tk.Label(self.item_frame, text=f"Add to Cart: {item_name}", font=("Arial", 12)).pack(pady=10)
        tk.Label(self.item_frame, text="Quantity:").pack()
        tk.Entry(self.item_frame, textvariable=self.quantity_var).pack()
        
        tk.Button(self.item_frame, text="Add", command=self.add_item).pack(pady=5)
        tk.Button(self.item_frame, text="Back to Menu", command=lambda: self.show_items(self.selected_category)).pack(pady=5)

    def add_item(self):
        try:
            quantity = self.quantity_var.get()
            if quantity > 0:
                message = self.controller.domino_app.add_to_cart(self.selected_item, quantity)
                messagebox.showinfo("Cart Updated", message)
                self.controller.show_frame("OrderMenuFrame")
            else:
                messagebox.showerror("Invalid Quantity", "Please enter a quantity greater than zero.")
        except tk.TclError:
            messagebox.showerror("Invalid Input", "Please enter a valid number for quantity.")

class CartFrame(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        
        self.cart_label = tk.Label(self, text="", font=("Arial", 12))
        self.cart_label.pack(pady=10)
        
        self.total_label = tk.Label(self, text="", font=("Arial", 12, "bold"))
        self.total_label.pack(pady=5)
        
        tk.Button(self, text="Back to Main Menu", command=lambda: controller.show_frame("MainMenuFrame")).pack(pady=10)
        
    def update_cart(self):
        status, total_price, summary = self.controller.domino_app.get_cart_summary()
        self.cart_label.config(text=summary)
        self.total_label.config(text=f"Total Price: ₹{total_price}")
        if status == "Your cart is empty.":
            messagebox.showinfo("Cart", status)

if __name__ == "__main__":
    app = App()
    app.mainloop()
```

### `sam.py`

```python
import pickle
with open('users.bin', 'rb') as f:
    l=pickle.load(f)
print(l)

for i in l:
    print(i)
    
'''

dummy_user = {'username': 'xyz', 'email': 'xyz@gmail.com', 'phno': '1234567890'}

with open('users.bin', 'wb') as f:
    pickle.dump([dummy_user], f)'''
```

### `wa.py`

```python
import pywhatkit

# Replace with the recipient's phone number (including country code)
phone_number = "+910000000000"

# The message you want to send
message = "ignore this is a automatic msg generated by pywhatkit \n testing purpose"

# Send the message instantly
try:
    pywhatkit.sendwhatmsg_instantly(phone_number, message)
    print("Message sent instantly!")
except Exception as e:
    print(f"An error occurred: {e}")
```

## Topics Covered

- Loops
- Functions
- Sets
- String Processing
- OOP / Classes

## Assignment / Homework

The programs practiced on this date are included above as the day's assignment/practice work.

## Quick Revision

- Review the logic of each program and understand why each condition, loop, function, or class member is used.
- Practice writing the programs again without copying the code.
- Test the programs with different inputs and boundary cases.
