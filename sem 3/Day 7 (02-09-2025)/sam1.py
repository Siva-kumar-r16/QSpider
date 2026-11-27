from datetime import datetime


class BankAccount:
    bankname = "MyBank"
    loc = "chennai"

    def __init__(self, name, pin, balance, acc_no):
        self.name = name
        self.balance = balance
        self.acc_no = acc_no
        self.pin = pin
        self.transactions = []

    def _validate_pin(self, entered_pin):
        if entered_pin == self.pin:
            return True
        else:
            print("Access denied. Incorrect PIN.")
            return False

    def display(self, entered_pin):
        if self._validate_pin(entered_pin):
            print("\n--- Account Details ---")
            print(f"Name: {self.name}")
            print(f"Balance: {self.balance}")
            print(f"Bank Name: {self.bankname}")
            print(f"Location: {self.loc}")
            print(f"Account Number: {self.acc_no}")

    def withdraw(self, amount, entered_pin):
        if self._validate_pin(entered_pin):
            if amount > 0:
                if amount <= self.balance:
                    self.balance -= amount
                    self.transactions.append({"type": "Withdrawal", "amount": amount, "timestamp": datetime.now().isoformat()})
                    print("Withdrawal successful.")
                else:
                    print("Insufficient funds.")
            else:
                print("Invalid withdrawal amount.")

    def deposit(self, amount, entered_pin):
        if self._validate_pin(entered_pin):
            if amount > 0:
                self.balance += amount
                self.transactions.append({"type": "Deposit", "amount": amount, "timestamp": datetime.now().isoformat()})
                print("Deposit successful.")
            else:
                print("Invalid deposit amount.")

    def check_balance(self, entered_pin):
        if self._validate_pin(entered_pin):
            print(f"Current balance: {self.balance}")

    def view_history(self, entered_pin):
        if self._validate_pin(entered_pin):
            print("\n--- Transaction History ---")
            if not self.transactions:
                print("No transactions to show.")
            for tx in self.transactions:
                timestamp = datetime.fromisoformat(tx['timestamp']).strftime('%Y-%m-%d %H:%M:%S')
                print(f"[{timestamp}] {tx['type']}: {tx['amount']}")

class SavingsAccount(BankAccount):
    def __init__(self, name, pin, balance, acc_no, interest_rate):
        super().__init__(name, pin, balance, acc_no)
        self.interest_rate = interest_rate

    def display(self, entered_pin):
        if self._validate_pin(entered_pin):
            super().display(entered_pin)
            print(f"Interest Rate: {self.interest_rate}")

class ChildrensAccount(SavingsAccount):
    def __init__(self, name, pin, balance, acc_no, interest_rate, age, guardian_name):
        if age <= 18:
            super().__init__(name, pin, balance, acc_no, interest_rate)
            self.guardian_name = guardian_name
        else:
            raise ValueError("Child's age must be 18 or under for a Children's Account.")

    def display(self, entered_pin):
        if self._validate_pin(entered_pin):
            super().display(entered_pin)
            print(f"Guardian Name: {self.guardian_name}")

class CurrentAccount(BankAccount):
    def __init__(self, name, pin, balance, acc_no, overdraft_limit):
        super().__init__(name, pin, balance, acc_no)
        self.overdraft_limit = overdraft_limit

    def withdraw(self, amount, entered_pin):
        if self._validate_pin(entered_pin):
            if amount > 0:
                if self.balance - amount >= -self.overdraft_limit:
                    self.balance -= amount
                    self.transactions.append({"type": "Withdrawal", "amount": amount, "timestamp": datetime.now().isoformat()})
                    print("Withdrawal successful. Current balance may be negative.")
                else:
                    print("Withdrawal denied. Exceeds overdraft limit.")
            else:
                print("Invalid withdrawal amount.")
                
class LoanAccount(SavingsAccount):
    def __init__(self, name, pin, balance, acc_no, interest_rate, loan_amount):
        super().__init__(name, pin, balance, acc_no, interest_rate)
        self.loan_amount = loan_amount

    def display(self, entered_pin):
        if self._validate_pin(entered_pin):
            print("\n--- Loan Account Details ---")
            super().display(entered_pin)
            print(f"Loan Amount: {self.loan_amount}")

all_accounts = [
    BankAccount("sarv", "1111", 1500, "12345"),
    BankAccount("sath", "2222", 500, "67890"),
    SavingsAccount("sanj", "3333", 2500, "54321", 0.05),
    SavingsAccount("siva", "4444", 10000, "09876", 0.03),
    ChildrensAccount("seprin", "5555", 50, "98765", 0.02, 12, "murugan"),
    ChildrensAccount("sant", "6666", 200, "45678", 0.01, 8, "guru"),
    CurrentAccount("sanjit", "7777", 5000, "11223", 2000),
    LoanAccount("sath", "8888", 0, "44556", 0.06, 10000)
]

def find_account(name, pin):
    for account in all_accounts:
        if account.name.lower() == name.lower() and account.pin == pin:
            return account
    return None

print("MyBank CLI Application")
while True:
    username = input("Enter your username (or 'exit' to quit): ").strip()
    if username.lower() == 'exit':
        break

    pin = input("Enter your 4-digit PIN: ").strip()

    user_account = find_account(username, pin)

    if user_account:
        print(f"\nWelcome, {user_account.name}!")
        while True:
            is_loan_account = isinstance(user_account, LoanAccount)
            
            print("\n--- Account Menu ---")
            if is_loan_account:
                print("1. Display Loan Info")
                print("2. Logout")
            else:
                print("1. Check Balance")
                print("2. Deposit")
                print("3. Withdraw")
                print("4. View Transaction History")
                print("5. Display Account Info")
                print("6. Logout")

            choice = input("Enter your choice: ").strip()

            if is_loan_account:
                if choice == '1':
                    user_account.display(pin)
                elif choice == '2':
                    print("Logging out...")
                    break
                else:
                    print("Invalid choice. Please try again.")
            else:
                if choice == '1':
                    user_account.check_balance(pin)
                elif choice == '2':
                    try:
                        amount = float(input("Enter deposit amount: "))
                        user_account.deposit(amount, pin)
                    except ValueError:
                        print("Invalid amount. Please enter a number.")
                elif choice == '3':
                    try:
                        amount = float(input("Enter withdrawal amount: "))
                        user_account.withdraw(amount, pin)
                    except ValueError:
                        print("Invalid amount. Please enter a number.")
                elif choice == '4':
                    user_account.view_history(pin)
                elif choice == '5':
                    user_account.display(pin)
                elif choice == '6':
                    print("Logging out...")
                    break
                else:
                    print("Invalid choice. Please try again.")
    else:
        print("Account not found. Please check your username and PIN.")

print("Goodbye!")
