
Scenario: S2 Sending a letter from yandex mail
Given user with credentials 'wdtest' and 'testtest7' is logged in
When user creates letter with <subject> and <body> <to>
And sends the letter
Then letter is sent

Examples:
|subject          |body              |to    |
|CDP_HW_Module_7_3|Hello from ThucyJB|wdtest@yandex.ru|