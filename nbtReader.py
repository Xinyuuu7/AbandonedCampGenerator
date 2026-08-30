import os
import nbtlib

directory = 'nbts'
filenames = []

for root, dirs, files in os.walk(directory):
    for fname in files:
        filenames.append(os.path.join(root, fname))

def load_snbt(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        content = f.read()
    return nbtlib.parse_nbt(content)

def gen_size():
    for filename in filenames:
        nbt_file = load_snbt(filename)
        size = nbt_file['size']
        text = 'this.put(\"' + filename[:-5].replace('\\', '/') + '\", new BPos('
        c = 0
        for integer in size:
            c += 1
            value = str(integer)[4:-1]
            text += value
            if c != 3:
                text += ','
        text += '));'
        print(text)

def gen_jigsaw():
    for filename in filenames:
        nbt_file = load_snbt(filename)
        datas = nbt_file['data']
        text = 'this.put(\"' + filename[:-5].replace('\\', '/') + '\", Arrays.asList(\n'
        first = True
        for data in datas:
            if 'nbt' not in data:
                continue
            nbt = data['nbt']
            blockid = nbt['id']
            if blockid != 'minecraft:jigsaw':
                continue
            if not first:
                text += ',\n'
            first = False

            # UNFINISHED!!!

        text += '\n));'
        print(text)


#gen_jigsaw()
gen_jigsaw()