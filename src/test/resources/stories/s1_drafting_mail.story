
Scenario: S1 Yandex mail letter autosaved to drafts
Given user with credentials 'wdtest' and 'testtest7' is logged in
When user creates letter with <subject> and <body> <to>
Then letter with <subject> and <body> <to> is saved in drafts

Examples:
|subject          |body              |to    |
|CDP_HW_Module_7_3|Hello from ThucyJB|wdtest@yandex.ru|