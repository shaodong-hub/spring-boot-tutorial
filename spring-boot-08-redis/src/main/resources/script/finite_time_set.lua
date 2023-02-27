local result = redis.call("EXISTS", KEYS[1]);
if result == 0 then
    redis.call("SADD", KEYS[1], ARGV[1]);
    redis.call("EXPIRE", KEYS[1], ARGV[2]);
    return 1;
end
return redis.call("SADD", KEYS[1], ARGV[1]);