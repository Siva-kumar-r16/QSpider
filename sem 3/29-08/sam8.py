#class method using college name

class panimalar:
    college_name="Panimalar Engineering College"
    location="Chennai"

    @classmethod
    def display_info(cls):
        print(cls.college_name, cls.location)

panimalar.display_info()