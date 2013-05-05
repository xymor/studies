
class Database
  
  @@db = Hash.new 
  
  @@transactions = []

  def set(name, value)
  	if transactions 
  		transactions.last.set(name,value)
  	else	
  		@@db[name] = value
  	end	
  end 
  
  def get(name)
    last_index = transactions.rindex(|t| t.get(name))
  	if last_index
  		transactions[-last_index][name]
  	else		
  		@@db[name] 
  end 
  
  def unset(name)
  	if transactions 
  		transactions.last.unset(name)
  	else	
  		@@db.delete name
  	end
  end   
  
  def numequalto(value)
 
  end
  
  def begin
  	transactions << Transaction.new
  end
  
  def commit
  	transactions.each do |unit|
  		unit.each_pair do |k,v|
  		  if v == null
  		  	@@db.delete k
  		  else
  		  	@@db[k] = v
  		  end
  		end
  	end
  end
  
  def rollback
  	@@transactions = @@transactions.pop
  end
end

class Transaction
	@@operations = Hash.new
	
	def set(name, value)
		@@operations[name] = value
	end
	
	def get(name)
		@@operations[name]
	end
	
	def unset(name)
		@@operations[name] = null
	end
	
	def numequalto(value)
		counter = 0
		@@operations.each_value{|v| counter+=1}
		counter
  	end
end

dbinstance = Database.new

loop do
	s = gets.chomp
	args = s.split(' ')
	begin
		puts dbinstance.send(args[0], *args[1..-1]) unless s == 'end'
	rescue Exception=>e
		puts "No method called #{args[0]}, sorry."
	end
		
	exit if s == 'end'
end

