#instance method by me

class Cricket:
    team="India"
    jersey="Blue"

    def __init__(self,name,age,role):
        self.name=name
        self.age=age
        self.role=role

    def display(self):
        print(self.name,self.age,self.role)

    def ch_name(self,new):
        self.name=new

c1=Cricket("Dhoni",40,"batsman")
c1.display()
c1.ch_name("Kohli")
c1.display()