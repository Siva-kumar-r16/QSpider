#multi level inheritance

class Grandfather:
    def __init__(self, g_name):
        self.g_name = g_name
    
    def house(self):
        print(f"This is {self.g_name}'s house.")

class Father(Grandfather):
    def __init__(self, f_name, g_name):
        super().__init__(g_name)
        self.f_name = f_name

    def house(self):
        print(f"This is {self.f_name}'s house.")

class Son(Father):
    def __init__(self, s_name, f_name, g_name):
        super().__init__(f_name, g_name)
        self.s_name = s_name

    def car(self):
        print(f"This is {self.s_name}'s car.")

son = Son("Siva", "Raj", "Kumar")
son.house()
son.car()