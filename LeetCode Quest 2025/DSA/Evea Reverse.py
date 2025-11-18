class Solution(object):
    def evalRPN(self, tokens):
        stack = []
        for t in tokens:
            if t
 not in ["+", "-", "*", "/"]:
                stack.append(int(t))
            else:
                b =
                a
 stack.pop()
 = stack.pop()
                if t
 == "+":
                    stack.append(a + b)
                elif t == "-":
                    stack.append(a - b)
                elif t == "*":
                    stack.append(a * b)
                else:
  # division
                    # Python division needs truncation toward zero
                    stack.append(int(float(a) / b))
        return stack[0]