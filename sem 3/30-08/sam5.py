class College:
    cname="panimalar"
    loc="chennai"

    def __init__(self,name,roll):
        self.name=name
        self.roll=roll

    def display(self):
        print(self.name,self.roll)

    def ch_roll(self,roll):
        self.roll=roll

    @classmethod
    def disp(cls):
        print(cls.cname, cls.loc)

    @classmethod
    def ch_loc(cls,new):
        cls.loc=new

    @staticmethod
    def msg():
        print("Welcome to", College.cname)

st1=College("Alice",1)
st2=College("Bob",2)
print("before modification:")
College.disp()
st1.display()
print("After modification:")
College.ch_loc("bangalore")
st1.ch_roll(56)
st1.display()
College.disp()

#static method
College.msg()
st1