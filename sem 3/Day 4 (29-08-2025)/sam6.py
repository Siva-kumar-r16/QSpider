#instance method
class Bank:
    bname="SBI"
    loc="chennai"

    def __init__(self,name,acc_no,ifsc):
        self.name=name
        self.acc_no=acc_no
        self.ifsc=ifsc

    def display(self):
        print(self.name,self.acc_no,self.ifsc)

    def ch_name(self,new):
        self.name=new

c1=Bank("siva",101,"sbi001")
c1.display()
c1.ch_name("ravi")
c1.display()