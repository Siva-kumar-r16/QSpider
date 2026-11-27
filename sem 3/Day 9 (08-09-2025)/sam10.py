from abc import ABC, abstractmethod
class bank(ABC):
    roi=4

    @abstractmethod
    def withdraw(self,amount):
        pass

class saving(bank):
    roi=5
    def withdraw(self, amount):
        print("hello")

obj=saving()
#obj2=bank()  # we cannot create object of abstract class