%dw 2.0
output application/json
---
payload map ( payload01 , indexOfPayload01 ) -> {
	id: payload01.id,
	full_name: payload01.player.first_name ++ " " ++ payload01.player.last_name,
	assists: payload01.ast,
	blocks: payload01.blk,
	rebounds: payload01.dreb + payload01.oreb,
	three_pointers_percentage: payload01.fg3_pct,
	field_goal_percentage: payload01.fg_pct,
	free_throw_percentaget: payload01.ft_pct,
	game_id: payload01.game.id,
	season: payload01.game.season,
	team: payload01.team.full_name
}