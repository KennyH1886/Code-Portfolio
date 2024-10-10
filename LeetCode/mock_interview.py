# Online Python compiler (interpreter) to run Python online.
# Write Python 3 code in this online editor and run it.
print("Try programiz.pro")
# alien language , english lower case , sometimes permutation letters , 
# given a sequence if and only if the words are sorted lexigraphically , return true and false otherwise 

def is_alien_sorted(words,order):
    # map each charater in order to its index 
    order_map = {char: idx for idx, char in enumerate(order)}
    print(order_map)
    # values and keys of order map ex: s:0 , f:1, p:3 etc...


    # returns true or false if each word in a list of words is lexigraphically ordered , if one is not then it will return false based off order of map.
    return all([is_word_sorted(word, order_map) for word in words])

    

def is_word_sorted(word, order_map):
    # checking if the word itself is sorted according to alien order
    for i in range(len(word) - 1):
        if order_map[word[i]] > order_map[word[i+1]]:
            return False
    return True

# alien langauge list of words , one is lexigraphical sorted letters 
f_word = ["what"]

words1 = ["agfgh","bdrwesfaf","cfrwdsaf"]
words2 = ["agfghadfqwterwfe","bdrwesfaf","cfrwdsafdsfsdaf"]

word2 = ["bdrwesfaf"]
word3 =  ["dsgerwgrewgewgrwegreg"]

order ="sfpemrhyajzwguvqtbikdoxlcn"

# test cases of alien sorted and  word sort functions
print(is_alien_sorted(words2,order)) 
print(is_word_sorted(word2, order))
print(is_word_sorted(f_word, order))
print(is_word_sorted(word3, order))
print(len(order))



# verify what question im being asked exactly , no wrong assumptions
# brush up on python syntax !!! 
# practice , following flow of interview
# do more before you code , 
# started off in the wrong direction 
# consider edge cases and ask 
# can I ask or assume if ther are repeats ?, what if its empty , single character 