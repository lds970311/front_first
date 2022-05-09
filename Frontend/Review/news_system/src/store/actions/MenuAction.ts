export function collapsedAction(data: boolean): IAction {
    return {
        type: 'changeCollapsed',
        payload: data
    }
}
