class Laptop:
    #class members
    brand='hp'
    warranty=2
    def __init__(self,model,color,processor,graphic_card):
        self.model=model
        self.color=color
        self.processor=processor
        self.graphic_card=graphic_card

lap1=Laptop("hp15s","silver","intel i5","iris 2GB")
lap2=Laptop("hp pavilion","black","intel i7","nvidia Gforce")
print(lap1.model,lap1.color,lap1.processor,lap1.graphic_card)
print(lap2.model,lap2.color,lap2.processor,lap2.graphic_card)