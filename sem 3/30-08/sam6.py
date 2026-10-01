#single inheritance

class Bank:
    bank_name = "My Bank"
    loc = "chennai"
 
    def __init__(self, name, acc_no, bal):
        self.name = name
        self.acc_no = acc_no
        self.bal=bal

        self.bal = bal
 
    def display(self):
        print(self.name, self.acc_no, f"${self.bal:,.2f}")
 
 
class Customer(Bank):
    def deposit(self, amount):
        if amount > 0:
            self.bal += amount
            print(f"Successfully deposited ${amount:,.2f}.")
            print(f"New balance is ${self.bal:,.2f}.")
        else:
            print("Error: Deposit amount must be positive.")
 
    def withdraw(self, amount):
        if amount <= 0:
            print("Error: Withdrawal amount must be positive.")
        elif self.bal >= amount:
            self.bal -= amount
            print(f"Successfully withdrew ${amount:,.2f}.")
            print(f"New balance is ${self.bal:,.2f}.")
        else:
            print(f"Error: Insufficient funds. Current balance is ${self.bal:,.2f}.")
 

    def ch_bal(self, bal):
        self.bal = bal




c1 = Customer(name="Siva", acc_no="12345", bal=5000)
c1.display()
 
c1.deposit(1500)
c1.withdraw(300)
c1.withdraw(7000) 
print("\nAfter transactions:")
c1.display()