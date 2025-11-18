class Solution(object):
    def maskPII(self, s):
        s = s.strip()
        # Check if it's an email
        if '@' in s:
            s = s.lower()
            name, domain = s.split('@')
            return name[0] + "*****" + name[-1] + "@" + domain
        # Otherwise it's a phone number
        digits = ''.join([c for c in s if c.isdigit()])
        local = "***-***-" + digits[-4:]
        country_len = len(digits) - 10
        if country_len > 0:
            return "+" + ("*" * country_len) + "-" + local
        else:
            return local
