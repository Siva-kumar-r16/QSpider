class BankAccount:
    def __init__(self, holder, balance=0):
        self.holder = holder
        self.balance = balance

    def show_balance(self):
        return f"Account Holder: {self.holder}, Balance: {self.balance}"

def hacked_method(self):
    return "Hacked!"

acc = BankAccount("LEO DAS", 1000)
print(acc.show_balance())

BankAccount.show_balance = hacked_method
print(acc.show_balance())