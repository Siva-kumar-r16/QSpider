class bank:
    #class members
    bank_name='Smith Bank'
    location='mulakumoodu'
    def __init__(self,a_no,a_ho_na,bal):
        self.a_no=a_no
        self.a_ho_na=a_ho_na
        self.bal=bal

acc1=bank(101,'shane jashwin',1000)
acc2=bank(102,'sanjay',2000)
print(acc1.a_no,acc1.a_ho_na,acc1.bal)
print(acc2.a_no,acc2.a_ho_na,acc2.bal)