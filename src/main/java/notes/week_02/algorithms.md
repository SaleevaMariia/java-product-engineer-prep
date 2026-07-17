# Week 2 Algorithms

## Remove Element
Pattern: writeIndex
- writeIndex points to next position for element != val
- return writeIndex

Time: O(n)
Space: O(1)

## Majority Element
HashMap:
- count frequency
- return when count > n / 2
- Time O(n), Space O(n)

Boyer-Moore:
- candidate + count
- count is vote balance
- if count == 0 choose new candidate
- Time O(n), Space O(1)

## Is Subsequence
Pattern: two pointers
- sIndex points to next char to match
- tIndex scans t
- order preserved because pointers only move forward