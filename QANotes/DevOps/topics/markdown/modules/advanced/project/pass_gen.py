import nltk
nltk.download('words')

import random
import string
from nltk.corpus import words

word_list = words.words()
string.ascii_letters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'

while 1:
	print("")
	strength = input("Do you want your password Weak (w), Mid (m) or Strong (s)?: ")
	strength.lower()
	if strength not in ["w", "m", "s"]:
		print("")
		print("Please enter valid selection")
		print(" ")
	else:
		break

if strength == "w":
	password = random.choice(word_list)

elif strength == "m":
	word = random.choice(word_list) 
	num = []
	for i in range(3):
		n = random.randint(1,9)
		num.append(n)
	password = word + ''.join(str(i) for i in num)

elif strength == "s":
	word = random.choice(word_list)
	letters = ""
	num = []
	for i in range(10):
		n = random.randint(1,10)
		num.append(n)
		l = random.choice(string.ascii_letters)
		letters += l
	password = word + ''.join(str(i) for i in num) + letters


print("")
print("Your password is: " + password)
print("")
