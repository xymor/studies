# https://www.codeeval.com/open_challenges/44/
# You are writing out a list of numbers.Your list contains all numbers 
#  with exactly Di digits in its decimal representation which are equal 
#  to i, for each i between 1 and 9, inclusive. You are writing them out 
#  in ascending order. For example, you might be writing every number with 
#  two '1's and one '5'. Your list would begin 115, 151, 511, 1015, 1051. 
#  Given N, the last number you wrote, compute what the next number in the 
#  list will be. The number of 1s, 2s, ..., 9s is fixed but the number of 0s 
#  is arbitrary. 

def next_int(number) 
	seq = ( number.to_s.chars.to_a + ["0"] ).permutation.to_a.sort.uniq.map{ | i | 
		i.join('').to_i
	}
	seq[ seq.index( number )+1 ]
end

File.open(ARGV[0]).each_line do | line |
    puts next_int( line.strip.to_i )
end
