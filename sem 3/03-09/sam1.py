class bankaccount:
    def __init__(self,account_holder,bal=0,pin=123):
        self.account_holder=account_holder
        self._bal=bal
        self.__pin=pin

    def get_balance(self,pin):
        if pin==self.__pin:
            return self._bal
        else:
            return "Invalid pin"

    def deposit(self,amount,pin):
        if pin==self.__pin:
            self._bal+=amount
            return f"deposited {amount}"
        else:
            return "Invalid pin"

a=bankaccount("sam",1000,1234)
print(a.get_balance(1234))
print(a._bal)
print(a._bankaccount__pin)
print(a.deposit(500,1234))