package spring.intern_quest_202504.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

/**
 * RoleHierarchyをJava Configで設定するクラス。
 * fromHierarchy()を使って階層を構築します。
 */
@Configuration
public class RoleHierarchyConfig {

    /**
     * RoleHierarchyのBeanを作成する。
     * fromHierarchy()を利用して階層を設定します。
     * @return RoleHierarchyオブジェクト
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        // RoleHierarchyUtils.fromHierarchyを使用してロール階層を設定
        return RoleHierarchyImpl.fromHierarchy("""
            generalManager > sectionManager
            sectionManager > deputyManager
            deputyManager > user
        """);
    }
}

