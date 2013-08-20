
//Multiples of 3 and 5
(1..<1000).collect{ nr -> 
    return !(nr % 3) || !(nr % 5) ? nr : 0
}.sum()
//233168

//Even Fibonacci numbers
def fib(max = 100,fibs = []){
    println fibs
    if(fibs.last() >= max){ fibs.pop(); return fibs.sum{ it % 2 ? it : 0 } } 
    fib(max,fibs + [fibs[-1] + fibs[-2]])
}

return fib(4000000,[1,2])