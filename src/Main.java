import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Main {

    public static void main(String[] args) {
        //jedis单实例测试
        //设置IP 端口
//        Jedis jedis = new Jedis("localhost",6379);
//        jedis.set("name","imooc");
//        String s = jedis.get("name");
//        System.out.println(s);
//        jedis.close();
//        连接池的方式
//        配置对象
        JedisPoolConfig config = new JedisPoolConfig();//这个是连接池！
        config.setMaxTotal(30);
        config.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //获得核心对象
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            jedis.set("name","张三");
            String s = jedis.get("name");
            System.out.println(s);
        }catch (Exception e){
            if (jedis!=null){
                jedis.close();
            }
            if (jedisPool!=null){
                jedisPool.close();
            }
        }



    }
}
