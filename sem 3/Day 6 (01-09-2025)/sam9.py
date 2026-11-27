class school:
    sname="eben"
    pname="JJ"
    no_of_pg=3
    loc="kalyan"

    def __init__(self,name,roll_no,age,std):
        self.name=name
        self.roll_no=roll_no
        self.age=age
        self.std=std

    def display(self):
        print(self.name,self.roll_no,self.age,self.std)

    @classmethod
    def sdisplay(cls):
        print(cls.sname)

    @staticmethod
    def wel():
        print("Welcome to the school")

s1=school("sam",101,15,10)
s1.wel()
s1.display()
s1.sdisplay()