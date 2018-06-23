# calcula-horas

$ lein run 3m + 4h
"4h3m ou 243m"
$ lein run 3 + 4h
"4h3m ou 243m"
$ lein run 3 + 4h3m
"4h6m ou 246m"
$ lein run 3 + 4h3
"4h6m ou 246m"
$ lein run 3 - 4h3
"-4h0m ou -240m"
$ lein run 3h3 - 4h3
"-1h0m ou -60m"
