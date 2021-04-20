#! /usr/bin/env python
from functions import get_state
import json
print(json.dumps(get_state(), indent=4))
