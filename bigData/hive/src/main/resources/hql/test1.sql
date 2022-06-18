create table test1
(
    name     string,
    friends  array<string>,
    children map<string, int>,
    address  struct<street :string, city :string>
)