def sort(xs):
    if len(xs) > 1:
        return merge(sort(xs[0:len(xs)/2]), sort(xs[len(xs)/2:]))
    return xs


def merge(x, s):
    if not x:
        return s
    elif not s:
        return x
    elif x[0] > s[0]:
        return [s[0]] + merge(x, s[1:])
    else:
        return [x[0]] + merge(x[1:], s)

print(sort([1,3,2,-100, 23,-101]))