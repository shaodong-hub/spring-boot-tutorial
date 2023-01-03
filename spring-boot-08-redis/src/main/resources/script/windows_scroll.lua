local result = redis.call("EXISTS", KEYS[1]);
if result == 0 then
    redis.call("SET", KEYS[1], 1);
    redis.call("EXPIRE", KEYS[1], ARGV[1]);
    return 1;
end
return redis.call("INCR", KEYS[1]);
