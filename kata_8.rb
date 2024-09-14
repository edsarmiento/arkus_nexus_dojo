# frozen_string_literal: true

class Arrays
  def initialize(a1, a2)
    @a1 = a1
    @a2 = a2
  end

  def process
    numbers ||= repeated_numbers
    puts "Result: #{array_lenght(numbers)}"
  end

  private

  attr_reader :a1, :a2

  def repeated_numbers
    smaller_array, larger_array = a1.length <= a2.length ? [a1, a2] : [a2, a1]

    aux = []
    smaller_array.each do |number|
      aux.concat(larger_array.select { |value| value == number })
    end
    aux
  end

  def array_lenght(repeated_numbers)
    aux = []
    repeated_numbers.each do |number|
      repeated_numbers.each do |sub_number|
        aux << number if (number + sub_number).abs == a1.length
        aux << number if (number + sub_number).abs == a2.length
        aux << number if (number - sub_number).abs == a1.length
        aux << number if (number - sub_number).abs == a2.length
      end
    end
    aux.uniq
  end
end

# [2, 4, 6]
Arrays.new(
  [1, 2, 3, 4, 5, 6],
  [1, 2, 4, 6, 7, 8, 9, 10]
).process

# [1, 3, 5, 15]
Arrays.new(
  [1, 2, 3, 5, 10, 15],
  [1, 2, 3, 4, 5, 6, 10, 12, 15, 16]
).process

