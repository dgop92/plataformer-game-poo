import json
import random
# tile_size = 32
# word_size = 800
tile_size = 48
word_size = 768
curr_blocks = ["1.0", "0.0"]

tilemap = []

for i in range(0, word_size, tile_size):
    row = []
    print(i)
    for j in range(0, word_size, tile_size):
        if i <= 500:
            row.append("0.0")
        else:
            row.append(random.choice(curr_blocks))
    tilemap.append(row)

with open('test-map16.json', 'w') as wf:
    json.dump(tilemap, wf)
