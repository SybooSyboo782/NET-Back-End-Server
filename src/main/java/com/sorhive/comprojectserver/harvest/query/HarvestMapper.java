package com.sorhive.comprojectserver.harvest.query;

import com.sorhive.comprojectserver.harvest.query.dto.HarvestCommentSummary;
import com.sorhive.comprojectserver.harvest.query.dto.HarvestImageSummary;
import com.sorhive.comprojectserver.harvest.query.dto.HarvestSummary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * Class : HarvestMapper
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       부시연           최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Mapper
public interface HarvestMapper {
    List<HarvestSummary> selectAllHarvest(Long memberCode, int pageNo);

    List<HarvestImageSummary> selectAllHarvestImages(Long harvestId);

    List<HarvestCommentSummary> selectAllHarvestComments(Long harvestId);
}
