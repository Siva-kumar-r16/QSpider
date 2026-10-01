class SavingsAccount:
    def withdraw():
        return "Withdraw from Savings"

class CurrentAccount:
    def withdraw():
        return "Withdraw from Current"
    
def process_withdrawal(account_type):
    print(account_type.withdraw())

process_withdrawal(SavingsAccount)
process_withdrawal(CurrentAccount)