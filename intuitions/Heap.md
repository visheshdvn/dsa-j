It is important to be able to decide which heap to use to solve a question.

For an e.g. Consider the question - Find the kth largest element in an array.

Intuition -
Consider a heap as a heightwise line of people. You don't manage that, you only ask for the 'peek' person ans line gives you that. & when you send a person to the line it auto arranges itself.

(Important: it is different from a sorted array, but you can use this as a starting thought.)

Now, getting the kth largest element from the array is like picking the kth person from the back of the line. But what if the people are coming in a stream and you don't have all of them already.
That means you can visit a person only once and you have to figure out the kth tallest person in realtime.

One process that we can use is -
- keep the first k people with you
- as new people come one at a time, always replace the shortest person with the new one if he's taller.

This way you'll end up having the k tallest people you've visited and you can easily return the shortest person among them. That's the kth tallest person right there.

This process was similar to using a min-heap for your problem.
Min-heap because you're always comparing the shortest among k values and replacing that if a new smaller value is found.
The heap readjusts and bring the new smallest value on the top, don't worry about that.

NOTE: here you have used a min heap of fixed size i.e. k

---

Next - How to solve this with a Max Heap? 
If you want to use a max heap to find the kth max person
- simply put all the people in the heap
- keep bringing out the first k people from the heap
- the kth poll is the guy

With this process the heap can grow as large as the input.


---

## Final Intuition


# whenever the use case is to find things like
- nth greatest
- n greatest/maximum

### Case 1 - sample is huge
use a min heap (bec we want to be replacing the min element most frequently)

### Case 2 - sample is small - medium
use a max heap - push everything in the heap
then extract n elements out of it.

(frequently replacing smallest element out of min heap adds unnecessary complexity)


vice-versa for case when you want to fond out nth minimum/n minimum etc.