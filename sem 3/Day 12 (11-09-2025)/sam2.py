#print hello world without using print

import sys
sys.stdout.write("hello world \n")


sys.stdout.write("enter something: \n")
a = sys.stdin.read()
sys.stdout.write("\nYou entered:")
sys.stdout.write(a)