class BankAccount:
    def interest_rate(self):
        return 4

class SavingAccount(BankAccount):
    type = "Saving Account"
    def interest_rate(self):
        return 6

s1 = SavingAccount()
print(s1.interest_rate())
