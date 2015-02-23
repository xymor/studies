# https://www.codeeval.com/open_challenges/7/
# You are given a prefix expression. Write a program which evaluates it. 

class String
  def polish
    if self.match( /[+*\/] \d+ \d+/ )
      astern  = $`.strip
      ahead   = $'.strip
      ops = $&.split(/ /)
      
      "#{astern} #{ops[1].to_i.send(ops[0].intern, ops[2].to_i)} #{ahead}".polish
    else
      self.strip
    end
  end
end

File.open(ARGV[0]).each_line do |line|
  puts line.chomp.polish
end
