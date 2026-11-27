class Hospital:
    hname="abd"
    loc="hyd"
    Phno="1234567890"
    fees=1000

    def __init__(self,name,pid,problem,phno):
        self.name=name
        self.pid=pid
        self.problem=problem
        self.phno=phno

    def display(self):
        print(self.name,self.pid,self.problem,self.phno)

    def ch_name(self,name):
        self.name=name

    #class methods-->access
    @classmethod
    def display(cls):
        print(cls.hname,cls.loc,cls.Phno,cls.fees)

    #class methods--> modification of loc
    @classmethod
    def ch_Hname(cls,new_hname):
        cls.hname=new_hname

p1=Hospital("John",101,"Fever","9876543210")
p1.display()
Hospital.display()
Hospital.ch_Hname("xyz")
Hospital.display()