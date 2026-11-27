import sys

def hello(*args,gap=" ",last='\n',file=sys.stdout,flush):
    n=gap.join(args)+last
    file.write(n)

hello("bad ass ma","leo das ma ",gap='❤️‍🔥',last="leo")