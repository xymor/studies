
class Database
  
  @@db = Hash.new 

  def set(name, value)
  	@@db[name] = value
  end 
  
  def get(name)
  	puts @@db["#{name}"]
  end 
  
  def unset(name)
  	@@db.delete name
  end   
  
  def numequalto(value)
  	  counter = 0
  	  @@db.each_value{|v| counter+=1}
  	  puts "#{counter} entries with value #{value}"
  end

end

dbinstance = Database.new

loop do
	s = gets.chomp
	args = s.split(' ')
	begin
		dbinstance.send(args[0], *args[1..-1]) unless s == 'end'
	rescue Exception=>e
		puts "No method called #{args[0]}, sorry."
	end
		
	exit if s == 'end'
end

