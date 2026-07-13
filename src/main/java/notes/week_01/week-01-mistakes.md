# Week 1 Mistakes

## Java memory
Do not say: "int is always stored on stack".
Better:
- local primitive variables are typically stored in stack frame
- primitive fields are stored inside objects on heap
- objects are stored on heap

## HashMap complexity
Do not say: "hash, bucket calculation and equals are linear operations".
Better:
- HashMap uses hashCode to calculate bucket index
- lookup goes directly to one bucket
- get/put are O(1) average
- collisions can make lookup worse

## Collision
Collision = different keys mapped to the same bucket.

## Staging area
Staging area = selected changes prepared for the next commit.

## Edge cases
Use concrete examples, not vague phrases.

Bad:
- no data
- only zeroes

Good:
- nums = [], target = 10 -> no solution
- nums = [0, 0, 0] -> [0, 0, 0]