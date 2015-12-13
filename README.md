# Object Animator Example

Three simple examples of using the Object Animators.

## Repeating Button

Shows a smooth back-to-forth animation that does not end. Uses a repeat count of INFINITE, and makes use of the REVERSE repeat mode.

## Persisting Button

Acts like the Repeating button, however, after a few oscillations, it stays in a fixed location which is different from it's original location.

## Random Button

This button generates a random, bounded number to define it's next translation location. Uses a postDelayed on a handler to continually update, and uses an animation duration of slightly longer than the Runnable delay time - this reduces the jerkiness in the motion when next moving to a previously unknown number.


License
-------

	The MIT License (MIT)

	Copyright (c) 2015 Suresh Joshi

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.

