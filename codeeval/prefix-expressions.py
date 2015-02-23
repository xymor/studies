import sys
import operator as op

with open(sys.argv[1], 'r') as f:
    lines = f.read().strip().splitlines()

for l in lines:
    ops = { "+": op.add, "*": op.mul, "/": op.truediv }

    s = []
    for i in l.split(' ')[::-1]:
        if i not in ops:
            s.append(int(i))
        else:
            result = ops[i](s.pop(), s.pop())
            s.append(result)
    print int(round(s.pop()))
